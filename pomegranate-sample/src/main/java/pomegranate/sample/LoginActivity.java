package pomegranate.sample;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.Objects;



public class LoginActivity extends AppCompatActivity {

    private TextInputLayout firstNameInput;
    private TextInputLayout lastNameInput;
    private CheckBox termsAndConditionsCheck;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firstNameInput = findViewById(R.id.first_name_input);
        lastNameInput = findViewById(R.id.last_name_input);
        termsAndConditionsCheck = findViewById(R.id.terms_and_conditions_check);
        termsAndConditionsCheck.setTag(R.id.checkable, "tag");
        loginButton = findViewById(R.id.login_button);
        findViewById(R.id.login_button);
    }

    private boolean validateForm() {
        if (!termsAndConditionsCheck.isChecked()) {
            termsAndConditionsCheck.setError(getString(R.string.please_agree_to_terms));
            return false;
        }

        String firstNameText = Objects.requireNonNull(firstNameInput.getEditText()).getText().toString();
        if (firstNameText.equals("jack")) {
            firstNameInput.setError(getString(R.string.error_invalid_credentials));
            lastNameInput.setError(getString(R.string.error_invalid_credentials));
            return false;
        }

        String lastNameText = Objects.requireNonNull(lastNameInput.getEditText()).getText().toString();
        if (lastNameText.equals("knife")) {
            firstNameInput.setError(getString(R.string.error_invalid_credentials));
            lastNameInput.setError(getString(R.string.error_invalid_credentials));
            return false;
        }

        return true;
    }

    private void clearErrors() {
        termsAndConditionsCheck.setError(null);
        firstNameInput.setError(null);
        lastNameInput.setError(null);
    }

    public void onLoginClick(View view) {
        clearErrors();

        boolean formIsValid = validateForm();
        if (formIsValid) {
            //TODO: go to next
        }
    }
}
