package slidenerd.vivz.navigationviewdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private RelativeLayout mRoot;
    private TextInputLayout mEmailLayout;
    private TextInputLayout mPasswordLayout;
    private EditText mInputEmail;
    private EditText mInputPassword;
    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mRoot = (RelativeLayout) findViewById(R.id.root_activity_second);
        mEmailLayout = (TextInputLayout) findViewById(R.id.input_layout);
        mPasswordLayout = (TextInputLayout) findViewById(R.id.input_password_layout);
        mInputEmail = (EditText) findViewById(R.id.input_email);
        mInputPassword = (EditText) findViewById(R.id.input_password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submit(View view) {
        boolean isEmptyEmail = isEmptyEmail();
        boolean isEmptyPassword = isEmptyPasswoprd();

        if (isEmptyEmail && isEmptyPassword) {
            Snackbar.make(mRoot, "One or More Field are black", Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.text_dismiss), mSnackBarClickListener)
                    .show();
            mPasswordLayout.setError("Password cannot be empty");
            mEmailLayout.setError("Email cannot be empty");
        } else if (isEmptyEmail) {
            mEmailLayout.setError("Email cannot be empty");
            mPasswordLayout.setError(null);
        } else if (isEmptyPassword) {
            mPasswordLayout.setError("Password cannot be empty");
            mEmailLayout.setError(null);
        } else {
            //All good here
            mPasswordLayout.setError(null);
            mEmailLayout.setError(null);
            Toast.makeText(SecondActivity.this, "Todo Bien!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isEmptyEmail() {
        return mInputEmail.getText() == null || mInputEmail.getText().toString().isEmpty();
    }

    public boolean isEmptyPasswoprd() {
        return mInputPassword.getText() == null || mInputPassword.getText().toString().isEmpty();
    }
}
