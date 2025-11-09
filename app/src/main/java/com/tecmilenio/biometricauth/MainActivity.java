package com.tecmilenio.biometricauth;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.BiometricManager;

import com.google.android.material.button.MaterialButton;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;
    private MaterialButton authenticateButton;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private Executor executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        authenticateButton = findViewById(R.id.authenticateButton);

        executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                statusText.setText(getString(R.string.auth_error) + " - " + errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                statusText.setText(getString(R.string.auth_success));
                Toast.makeText(MainActivity.this, getString(R.string.auth_success), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                statusText.setText(getString(R.string.auth_failed));
            }
        });

        promptInfo = BiometricHelper.buildPromptInfo(this);

        checkBiometricAvailability();

        authenticateButton.setOnClickListener(v -> {
            BiometricManager bm = BiometricManager.from(this);
            int canAuth = bm.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG
                    | BiometricManager.Authenticators.BIOMETRIC_WEAK
                    | BiometricManager.Authenticators.DEVICE_CREDENTIAL);

            if (canAuth == BiometricManager.BIOMETRIC_SUCCESS) {
                biometricPrompt.authenticate(promptInfo);
                statusText.setText("Escaneando huella...");
            } else if (canAuth == BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED) {
                statusText.setText(getString(R.string.biometric_not_enrolled));
            } else {
                statusText.setText(getString(R.string.biometric_not_supported));
            }
        });
    }

    private void checkBiometricAvailability() {
        if (!BiometricHelper.isBiometricAvailable(this)) {
            statusText.setText(getString(R.string.biometric_not_supported));
            authenticateButton.setEnabled(false);
            return;
        }
        if (!BiometricHelper.hasEnrolledBiometrics(this)) {
            statusText.setText(getString(R.string.biometric_not_enrolled));
        }
    }
}