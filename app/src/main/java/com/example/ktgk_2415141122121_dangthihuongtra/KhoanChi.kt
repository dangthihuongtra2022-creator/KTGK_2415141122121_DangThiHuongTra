package com.example.ktgk_2415141122121_dangthihuongtra

import java.io.Serializable

data class KhoanChi(
    val maKhoanChi_121: String,
    var tenKhoanChi_121: String,
    var soTien_121: Double,
    var ghiChu_121: String,
    var daThanhToan_121: Boolean
) : Serializable {

    fun layThongTin_121(): String {
        val trangThai_121 = if (daThanhToan_121) "Đã thanh toán" else "Chưa thanh toán"
        return "Mã: $maKhoanChi_121\nTên: $tenKhoanChi_121\nSố tiền: $soTien_121 VNĐ\nGhi chú: $ghiChu_121\nTrạng thái: $trangThai_121"
    }

    fun laSoTienHopLe_121(): Boolean {
        return soTien_121 > 0
    }
}
