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
import hotchemi.android.rate.AppRate;

public class HomeActivity extends AppCompatActivity {
 @BindView(R.id.logout)
Button btnLogout;
  
FirebaseAuth mFirebaseAuth;
@BindView(R.id.sell)
Button btnSell;
@BindView(R.id.buy)
Button btnBuy;

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);

    AppRate.with(this)
            .setInstallDays(1)
            .setLaunchTimes(3)
            .setRemindInterval(2)
            .monitor();

    AppRate.showRateDialogIfMeetsConditions(this);

    btnLogout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FirebaseAuth.getInstance().signOut();
            Intent intentToMain = new Intent(HomeActivity.this, LoginActivity.class);
            AppRate.with(HomeActivity.this).showRateDialog(HomeActivity.this);
            startActivity(intentToMain);

        }
    });

    btnSell.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

                Toast.makeText(HomeActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();

                Intent intentToSell = new Intent(HomeActivity.this, SellActivity.class);
                startActivity(intentToSell);

        }
    });

    btnBuy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Toast.makeText(HomeActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();

            Intent intentToSell = new Intent(HomeActivity.this, ProductsActivity.class);
            startActivity(intentToSell);

        }
    });

}

}
