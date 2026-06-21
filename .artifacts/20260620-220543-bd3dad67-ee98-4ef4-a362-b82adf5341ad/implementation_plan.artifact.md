# Implementation Plan - Pertemuan 13 (Camera & QR)

The goal is to implement Camera Capture, QR Code Generation, and QR Code Scanning as described in the provided text instructions for Pertemuan 13.

## Proposed Changes

### UI Layer (Layouts)

#### [fragment_tab_capture.xml](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/res/layout/fragment_tab_capture.xml)
- Update layout with an `ImageView` and a `MaterialButton` for capturing photos.

#### [fragment_tab_qrcode.xml](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/res/layout/fragment_tab_qrcode.xml)
- Update layout with a `TextInputEditText`, `MaterialButton`, and `ImageView` for QR generation.

#### [fragment_tab_scan.xml](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/res/layout/fragment_tab_scan.xml)
- Update layout with a `PreviewView`, a frame `View`, and a `TextView` for scan results.

#### [activity_thirteenth.xml](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/res/layout/activity_thirteenth.xml)
- Ensure it has the `Toolbar`, `TabLayout`, and `ViewPager2`.

### Logic (Fragments & Activity)

#### [ThirteenthActivity.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/Pertemuan_13/ThirteenthActivity.kt)
- Update to use View Binding and initialize the ViewPager2 with `ThirteenthTabAdapter`.

#### [TabCaptureFragment.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/Pertemuan_13/TabCaptureFragment.kt)
- Implement camera capture logic using `ActivityResultContracts.StartActivityForResult()` and `MediaStore`.

#### [TabQrcodeFragment.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/Pertemuan_13/TabQrcodeFragment.kt)
- Implement QR generation logic using the `ZXing` library.

#### [TabScanFragment.kt](file:///D:/KELAS KAMPUS/SEMESTER 4/fajar-time-mobile/app/src/main/java/com/example/fajar_time/Home/Pertemuan_13/TabScanFragment.kt)
- Implement QR scanning logic using `CameraX` and `ML Kit Barcode Scanning`.

## Verification Plan

### Manual Verification
- **Capture**: Test capturing a photo and verify it displays in the `ImageView` and is saved to the gallery.
- **Generate**: Input text, click generate, and verify a QR code is displayed.
- **Scan**: Point the camera at a QR code and verify the text is displayed in the result `TextView`.
