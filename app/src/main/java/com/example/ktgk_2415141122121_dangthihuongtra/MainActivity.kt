package com.example.ktgk_2415141122121_dangthihuongtra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edtTenKhoanChi_121: EditText
    private lateinit var edtSoTien_121: EditText
    private lateinit var edtGhiChu_121: EditText
    private lateinit var btnThem_121: Button
    private lateinit var btnXemChiTiet_121: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Thiết lập tiêu đề Toolbar theo đúng yêu cầu
        supportActionBar?.title = "Đặng Thị Hương Trà - 2415141122121 - Quản lý chi tiêu cá nhân"

        edtTenKhoanChi_121 = findViewById(R.id.edtTenKhoanChi_121)
        edtSoTien_121 = findViewById(R.id.edtSoTien_121)
        edtGhiChu_121 = findViewById(R.id.edtGhiChu_121)
        btnThem_121 = findViewById(R.id.btnThem_121)
        btnXemChiTiet_121 = findViewById(R.id.btnXemChiTiet_121)

        // Xử lý sự kiện nút Thêm khoản chi
        btnThem_121.setOnClickListener {
            val ten_121 = edtTenKhoanChi_121.text.toString().trim()
            val soTienStr_121 = edtSoTien_121.text.toString().trim()

            if (ten_121.isEmpty()) {
                Toast.makeText(this, "Tên khoản chi không được để trống!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (soTienStr_121.isEmpty() || soTienStr_121.toDoubleOrNull() == null || soTienStr_121.toDouble() <= 0) {
                Toast.makeText(this, "Số tiền không hợp lệ!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Thêm khoản chi thành công!", Toast.LENGTH_SHORT).show()
        }

        // Xử lý sự kiện nút Xem chi tiết khoản chi (tạm thời chuyển sang màn hình trống hoặc chuẩn bị cho Câu 2)
        btnXemChiTiet_121.setOnClickListener {
            val ten_121 = edtTenKhoanChi_121.text.toString().trim()
            val soTienStr_121 = edtSoTien_121.text.toString().trim()
            val ghiChu_121 = edtGhiChu_121.text.toString().trim()

            if (ten_121.isEmpty() || soTienStr_121.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ tên và số tiền trước khi xem chi tiết!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Khi làm xong câu 2 sẽ mở ChiTietChiTieuActivity, tạm thời để code Intent
            val intent_121 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                putExtra("TEN_KHOAN_CHI", ten_121)
                putExtra("SO_TIEN", soTienStr_121)
                putExtra("GHI_CHU", ghiChu_121)
            }
            startActivity(intent_121)
        }
    }
}