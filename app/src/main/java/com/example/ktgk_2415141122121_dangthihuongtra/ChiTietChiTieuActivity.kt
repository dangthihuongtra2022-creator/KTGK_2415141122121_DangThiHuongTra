package com.example.ktgk_2415141122121_dangthihuongtra

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {
    private lateinit var txtThongTinChiTiet_121: TextView
    private lateinit var btnQuayLai_121: Button
    private lateinit var btnSua_121: Button

    private var tenKhoanChi_121: String = ""
    private var soTien_121: Double = 0.0
    private var ghiChu_121: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Đặng Thị Hương Trà - 2415141122121 - Chi Tiết Khoản Chi"

        txtThongTinChiTiet_121 = findViewById(R.id.txtThongTinChiTiet_121)
        btnQuayLai_121 = findViewById(R.id.btnQuayLai_121)
        btnSua_121 = findViewById(R.id.btnSua_121)

        val ten_121 = intent.getStringExtra("TEN_KHOAN_CHI")
        val soTienStr_121 = intent.getStringExtra("SO_TIEN")
        ghiChu_121 = intent.getStringExtra("GHI_CHU") ?: ""

        if (ten_121.isNullOrBlank() || soTienStr_121.isNullOrBlank() || soTienStr_121.toDoubleOrNull() == null || soTienStr_121.toDouble() <= 0) {
            Toast.makeText(this, "Dữ liệu không hợp lệ hoặc thiếu!", Toast.LENGTH_LONG).show()
            txtThongTinChiTiet_121.text = "Lỗi: Dữ liệu truyền sang không hợp lệ."
        } else {
            tenKhoanChi_121 = ten_121
            soTien_121 = soTienStr_121.toDouble()
            txtThongTinChiTiet_121.text = "Tên khoản chi: $tenKhoanChi_121\nSố tiền: $soTien_121 VNĐ\nGhi chú: $ghiChu_121"
        }

        btnQuayLai_121.setOnClickListener {
            finish()
        }
        btnSua_121.setOnClickListener {
            val intentKetQua_121 = intent.apply {
                putExtra(" KET_QUAC_SUA", "Đã cập nhật khoản chi: $tenKhoanChi_121")
            }
            setResult(RESULT_OK, intentKetQua_121)
            finish()
        }
    }
}