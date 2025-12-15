<?php
// Nama file video yang diminta, contoh: ?file=video1.mp4
$FileName = isset($_GET['file']) ? $_GET['file'] : '';

if ($FileName === '') {
    http_response_code(400);
    echo "No file specified.";
    exit;
}

// Path folder tempat video disimpan
$VideoPath = __DIR__ . "/Videos/" . $FileName;

if (!file_exists($VideoPath)) {
    http_response_code(404);
    echo "Video not found.";
    exit;
}

// Ambil informasi file
$FileSize = filesize($VideoPath);
$File = fopen($VideoPath, "rb");

// Header penting agar Android bisa streaming video
header("Content-Type: video/mp4");
header("Content-Length: $FileSize");
header("Accept-Ranges: bytes");

// Kirim isi file
fpassthru($File);

fclose($File);
exit;
?>
