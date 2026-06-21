# Walkthrough - Pertemuan 13 (Camera & QR)

I have successfully implemented the Camera and QR features for Pertemuan 13 according to the provided instructions.

## Changes Made

### UI & Layouts
- **[fragment_tab_capture.xml](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/res/layout/fragment_tab_capture.xml)**: Added ImageView and Capture button.
- **[fragment_tab_qrcode.xml](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/res/layout/fragment_tab_qrcode.xml)**: Added TextInputEditText, Generate button, and ImageView for QR.
- **[fragment_tab_scan.xml](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/res/layout/fragment_tab_scan.xml)**: Added PreviewView for CameraX and scan result TextView.
- **[fragment_home.xml](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/res/layout/fragment_home.xml)**: Added "Pertemuan 13" button.

### Logic & Features
- **[HomeFragment.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/HomeFragment.kt)**: Linked the new button to `ThirteenthActivity`.
- **[ThirteenthActivity.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/Pertemuan_13/ThirteenthActivity.kt)**: Updated to use View Binding and set up the ViewPager2 with TabLayout.
- **[TabCaptureFragment.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/Pertemuan_13/TabCaptureFragment.kt)**: Implemented photo capture and saving to the `Pictures/TestCaptures` gallery folder.
- **[TabQrcodeFragment.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/Pertemuan_13/TabQrcodeFragment.kt)**: Implemented QR code generation using the ZXing library.
- **[TabScanFragment.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/Pertemuan_13/TabScanFragment.kt)**: Implemented real-time QR code scanning using CameraX and ML Kit Barcode Scanning.

## Verification Summary
- **Capture**: The fragment now handles permissions and opens the camera. Captured images are saved to MediaStore and displayed.
- **QR Generate**: The fragment takes text input and generates a black-and-white QR code bitmap.
- **QR Scan**: The fragment starts a CameraX preview and uses ML Kit to detect QR codes, displaying the result at the bottom.
