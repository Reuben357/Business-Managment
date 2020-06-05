package www.reuben.businessmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
 @BindView(R.id.logout)
Button btnLogout;
FirebaseAuth mFirebaseAuth;
@BindView(R.id.sell)
Button btnSell;

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);

    btnLogout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FirebaseAuth.getInstance().signOut();
            Intent intentToMain = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intentToMain);
        }
    });

    btnSell.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(HomeActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();

                Intent intentToSell = new Intent(HomeActivity.this, ProductActivity.class);
                startActivity(intentToSell);
            }
    });

}

}
