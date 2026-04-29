# 📱 Menu & Navigasi Android

Aplikasi Android sederhana yang mengimplementasikan sistem menu dan navigasi menggunakan **Options Menu** (ActionBar) dan **Navigation Drawer** — dibuat sebagai tugas praktikum Pemrograman Mobile.

---

## ✨ Fitur

| Fitur | Deskripsi |
|---|---|
| 📋 Options Menu | Menu di ActionBar berisi Search, Info, Favourites, dan Settings |
| 🗂️ Navigation Drawer | Panel geser dari kiri berisi Home, Profile, dan Keluar |
| 📄 Fragment Navigation | Tiap item drawer nampilin halaman berbeda (HomeFragment & ProfileFragment) |
| 🔍 SearchView | Kolom pencarian terintegrasi langsung di ActionBar |
| 🌙 Light / Dark Mode | Ganti tema aplikasi secara langsung tanpa restart |
| 💬 AlertDialog | Dialog konfirmasi keluar dan dialog info aplikasi |

---

## 🛠️ Tech Stack

- **Language:** Java
- **Min SDK:** 24 (Android 7.0 Nougat)
- **Target SDK:** 36
- **UI Library:** Material Design 3
- **Navigation:** Fragment + DrawerLayout + NavigationView

---

## 📁 Struktur Project

```
app/src/main/
├── java/com/example/muenunavigasi/
│   ├── MainActivity.java       # Activity utama
│   ├── HomeFragment.java       # Halaman Home
│   └── ProfileFragment.java    # Halaman Profile
│
└── res/
    ├── layout/
    │   ├── activity_main.xml   # Layout DrawerLayout utama
    │   ├── fragment_home.xml   # Layout halaman Home
    │   └── fragment_profile.xml# Layout halaman Profile
    ├── menu/
    │   ├── main_menu.xml       # Options Menu (ActionBar)
    │   └── drawer_menu.xml     # Navigation Drawer menu
    └── values/
        ├── strings.xml
        ├── colors.xml
        └── themes.xml
```

---

## 🚀 Cara Jalankan

1. Clone repo ini
   ```bash
   git clone https://github.com/username/menu-navigasi-android.git
   ```
2. Buka di **Android Studio**
3. Tunggu Gradle sync selesai
4. Run di emulator atau device fisik (min Android 7.0)

---



---

## 👤 Author

**ADIB DIABI**   
Kelas: XI PPLG A
PPB


---

## 📄 Lisensi

Project ini dibuat untuk keperluan tugas praktikum. Free to use.
