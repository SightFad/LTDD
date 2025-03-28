package com.sinhvien.doan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private TextView profileName;
    private Button btnSavePayment;
    private Button btnSignout;
    private Button btnBack;
    private Button btnLinkAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_profile);

        // Khởi tạo DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Khai báo và ánh xạ các ID từ layout
        profileName = findViewById(R.id.profileName);
        btnSavePayment = findViewById(R.id.btnSavePayment);
        btnSignout = findViewById(R.id.btnSignout);
        btnBack = findViewById(R.id.btnBack);
        btnLinkAccounts = findViewById(R.id.btnLinkAccounts);

        // Hiển thị email từ Firebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            profileName.setText(user.getEmail());
        }

        // Lưu thông tin thanh toán (tạm thời chỉ hiển thị Toast)
        btnSavePayment.setOnClickListener(v -> {
            Toast.makeText(this, "Không có thông tin để lưu!", Toast.LENGTH_SHORT).show();
        });

        // Đăng xuất
        btnSignout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            finish();
        });

        // Quay lại
        btnBack.setOnClickListener(v -> finish());

        // Chuyển sang trang liên kết tài khoản
        btnLinkAccounts.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, LinkAccountsActivity.class);
            startActivity(intent);
        });
    }
}