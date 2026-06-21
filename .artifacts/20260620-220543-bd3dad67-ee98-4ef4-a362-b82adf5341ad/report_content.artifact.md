# Konten Laporan Analisis Pertemuan 13

Dokumen ini berisi bahan untuk mengisi **4 Zona Analisis** di Excalidraw sesuai instruksi tugas.

---

## 🎨 Zona 1: Planning, Alur & Wireframe

### Planning
1. **Setup Environment**: Menambahkan dependency CameraX, ML Kit, dan ZXing di `build.gradle`.
2. **Permission Handling**: Mengatur izin kamera dan penyimpanan di `AndroidManifest.xml`.
3. **UI Layout**: Membuat TabLayout dengan 3 fragmen utama (Capture, Scan, Generate).
4. **Implementation**: Coding fitur kamera (CameraX/Intent), Scanning (ML Kit), dan QR Generator (ZXing).

### Flowchart Sederhana
- **Capture**: User klik button ➡️ Izin Kamera diminta ➡️ Kamera terbuka ➡️ Ambil Foto ➡️ Simpan ke MediaStore ➡️ Muncul di ImageView.
- **Generate**: User input teks ➡️ Klik Generate ➡️ BitMatrix dibuat (ZXing) ➡️ Bitmap di-render ke ImageView.
- **Scan**: Kamera aktif (CameraX) ➡️ ImageAnalyzer deteksi frame ➡️ ML Kit baca Barcode ➡️ Hasil teks tampil di TextView.

---

## 💻 Zona 2: Bedah Kode (Code Annotation)

### Potongan Kode 1: Camera Intent (TabCaptureFragment)
```kotlin
private fun openCamera() {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) // 1. Panggil aplikasi kamera bawaan
    currentPhotoUri = createGalleryPhotoUri() // 2. Siapkan tempat simpan foto
    intent.putExtra(MediaStore.EXTRA_OUTPUT, currentPhotoUri) // 3. Beritahu kamera simpan ke URI ini
    cameraLauncher.launch(intent) // 4. Jalankan kamera
}
```
**Analisis:** Kode ini menggunakan Intent implisit untuk memanggil kamera Android tanpa harus membuat UI kamera sendiri. Poin pentingnya adalah `currentPhotoUri` yang berfungsi sebagai "wadah" kosong sebelum foto diambil.

### Potongan Kode 2: QR Logic (TabQrcodeFragment)
```kotlin
val matrix = writer.encode(text, BarcodeFormat.QR_CODE, 500, 500) // 1. Ubah teks jadi matriks 0 dan 1
return Bitmap.createBitmap(500, 500, Bitmap.Config.RGB_565).apply {
    for (x in 0 until 500) {
        for (y in 0 until 500) {
            setPixel(x, y, if (matrix.get(x, y)) Color.BLACK else Color.WHITE) // 2. Gambar piksel hitam/putih
        }
    }
}
```
**Analisis:** Matriks hasil library ZXing berisi data biner. Kita secara manual melakukan *looping* untuk mewarnai setiap piksel Bitmap: jika matriks bernilai `true` maka warnai Hitam, jika `false` warnai Putih.

---

## 🚨 Zona 3: Jurnal Error (Troubleshooting Diary)

1. **Error: `FileProvider` - `IllegalArgumentException: Failed to find configured root`**
   - **Penyebab**: Path di `file_paths.xml` tidak sesuai dengan URI yang dibuat di kode.
   - **Solusi**: Menyesuaikan `<external-files-path>` agar menunjuk ke folder yang benar (Pictures).

2. **Error: `CameraX` - `ExperimentalGetImage` Warning/Error**
   - **Penyebab**: API `imageProxy.image` masih bersifat eksperimental di library CameraX.
   - **Solusi**: Menambahkan anotasi `@androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)` di atas fungsi `startCamera()`.

3. **Error: App Crash saat klik "Capture" di Android 10+**
   - **Penyebab**: Mencoba menulis file ke root storage secara langsung tanpa menggunakan `ContentValues` (MediaStore API).
   - **Solusi**: Menggunakan `createGalleryPhotoUri()` dengan `ContentResolver.insert` agar sesuai dengan aturan Scoped Storage Android terbaru.

---

## 📸 Zona 4: Capture dan Jurnal Materi

### Pembahasan Materi:
- **CameraX**: Library Jetpack yang memudahkan integrasi kamera dengan dukungan siklus hidup (lifecycle-aware).
- **ML Kit**: SDK dari Google untuk machine learning, digunakan di sini khusus untuk Barcode Scanning secara offline.
- **MediaStore API**: Cara standar Android untuk berinteraksi dengan file media (foto/video) agar otomatis muncul di galeri.
- **ZXing (Zebra Crossing)**: Library open-source populer untuk pemrosesan barcode dan QR code.
