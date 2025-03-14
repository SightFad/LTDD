package com.sinhvien.doan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Category3Activity extends AppCompatActivity {
    private RecyclerView rvListC;
    private ProductAdapter productAdapter;
    private ArrayList<Product> lstProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category3);

        // Xử lý nút "Back"
        Button button = findViewById(R.id.btnback);
        button.setOnClickListener(v -> finish()); // Trả về MainActivity

        // Ánh xạ RecyclerView
        rvListC = findViewById(R.id.rvList);
        lstProduct = new ArrayList<>();

        // Load dữ liệu sản phẩm
        LoadData();

        // Thiết lập Adapter và LayoutManager cho RecyclerView
        productAdapter = new ProductAdapter(this,lstProduct);
        rvListC.setAdapter(productAdapter);
        rvListC.setLayoutManager(new LinearLayoutManager(this));

        // Xử lý hiển thị tự động căn lề
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rvList), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void LoadData() {
        lstProduct.add(new Product("9", "Bánh kem trà xanh", "Bánh kem trà xanh là bánh được làm từ bột trà xanh Nhật Bản (matcha), mang hương vị thanh nhẹ, hơi đắng nhưng hài hòa với vị ngọt.", "matcha.jpg", R.drawable.matcha));
        lstProduct.add(new Product("10", "Bánh kem xoài phủ lớp kem cheese", "Bánh kem xoài phủ lớp kem cheese là bánh kem xoài mềm mịn, thường có lớp bánh bông lan xốp nhẹ, xen kẽ với kem tươi béo ngậy và xoài tươi ngọt thanh.", "mango.jpg", R.drawable.mango));
        lstProduct.add(new Product("11", "Bánh kem trái cây", "Bánh kem trái cây là loại bánh bông lan mềm mịn, phủ lớp kem tươi béo ngậy và trang trí với các loại trái cây tươi như dâu, kiwi, xoài, việt quất,… tạo hương vị thanh mát, ngọt dịu.", "traicay.jpg", R.drawable.traicay));
        lstProduct.add(new Product("12", "Bánh kem chanh tươi ", "Bánh kem chanh tươi có lớp bánh mềm mịn, vị chua thanh mát, kết hợp kem béo ngậy và sốt chanh thơm dịu. ", "lemoncake.jpg", R.drawable.lemoncake));

    }
}
