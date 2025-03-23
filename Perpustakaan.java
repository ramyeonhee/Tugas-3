import java.util.*;

class Buku {
    private String judul;
    private Penulis penulis;
    private String kategori;
    private int tahunTerbit;
    private String sinopsis;

    // Constructor untuk semua atribut
    public Buku(String judul, Penulis penulis, String kategori, int tahunTerbit, String sinopsis) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.tahunTerbit = tahunTerbit;
        this.sinopsis = sinopsis;
    }

    // Getter untuk semua atribut
    public String getJudul() {
        return judul;
    }

    public Penulis getPenulis() {
        return penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    // Method untuk menampilkan informasi buku
    public void displayInfo() {
        System.out.printf("%-40s", judul);
        System.out.printf("%-15d", tahunTerbit);
        System.out.printf("%-15s", kategori);
        System.out.println("");
        penulis.displayInfo();
        System.out.println("Sinopsis: " + sinopsis);
    }

    // Method untuk menghitung jumlah kata dalam sinopsis
    public int hitungJumlahKataSinopsis() {
        if (sinopsis == null || sinopsis.isEmpty()) {
            return 0;
        }
        String[] kata = sinopsis.split("\\s+"); // Memisahkan string menjadi kata-kata
        return kata.length;
    }

    // Method untuk memeriksa tingkat kesamaan antara dua buku
    public double cekTingkatKesamaan(Buku bukuLain) {
        int kesamaan = 0;
        if (this.judul.equals(bukuLain.judul)) {
            kesamaan++;
        }
        if (this.penulis.getNama().equals(bukuLain.penulis.getNama())) {
            kesamaan++;
        }
        if (this.kategori.equals(bukuLain.kategori)) {
            kesamaan++;
        }
        if (this.tahunTerbit == bukuLain.tahunTerbit) {
            kesamaan++;
        }
        if (this.sinopsis.equals(bukuLain.sinopsis)) {
            kesamaan++;
        }

        return (double) kesamaan / 5 * 100;
    }

    // Method untuk membuat salinan buku
    public Buku copy() {
        return new Buku(this.judul, this.penulis, this.kategori, this.tahunTerbit, this.sinopsis);
    }

    // Method hitungRoyalti dengan 1 parameter (10% dari penjualan)
    public double hitungRoyalti(double hargaBuku) {
        return 0.10 * hargaBuku;
    }

    // Method hitungRoyalti dengan 2 parameter (persentase royalti ditentukan pengguna)
    public double hitungRoyalti(double hargaBuku, double persenRoyalti) {
        return (persenRoyalti / 100) * hargaBuku;
    }
}

class Penulis {
    private String nama;

    // Constructor untuk Penulis
    public Penulis(String nama) {
        this.nama = nama;
    }

    // Getter untuk nama penulis
    public String getNama() {
        return nama;
    }

    // Method untuk menampilkan informasi penulis
    public void displayInfo() {
        System.out.printf("%-35s", nama);
    }
}

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat beberapa objek Buku
        List<Buku> daftarBuku = new ArrayList<>();
        daftarBuku.add(new Buku("Dasar-Dasar Teknik Informatika", new Penulis("Novega Pratama Adiputra"), "Teknologi", 2021, "Buku ini membahas dasar-dasar teknologi informatika secara komprehensif."));
        daftarBuku.add(new Buku("Pengantar Teknologi Informasi", new Penulis("Buhari Muslim"), "Teknologi", 2019, "Buku ini memberikan pengenalan tentang teknologi informasi."));
        daftarBuku.add(new Buku("Sistem dan Peralatan Komputer", new Penulis("Luh Joni Adhi Wirawan"), "Teknologi", 2020, "Buku ini membahas sistem dan peralatan komputer secara mendalam."));
        daftarBuku.add(new Buku("Clean Code", new Penulis("Robert Cecil Martin"), "Teknologi", 2008, "Buku ini membahas tentang bagaimana menulis kode yang bersih dan mudah dipahami."));
        daftarBuku.add(new Buku("Aplikai Komputer", new Penulis("Dwi Kristanto"), "Teknologi", 2022, "Buku ini membahas tentang berbagai aplikasi komputer yang berguna dalam kehidupan sehari-hari."));

        daftarBuku.add(new Buku("Filsafat Modern", new Penulis("Amsal Bakhtiar"), "Filsafat", 2020, "Buku ini membahas tentang perkembangan filsafat modern dan tokoh-tokohnya."));
        daftarBuku.add(new Buku("Filsafat Agama", new Penulis("Rudi Anshory"), "Filsafat", 2021, "Buku ini membahas tentang hubungan antara filsafat dan agama serta berbagai perspektifnya."));
        daftarBuku.add(new Buku("Filsafat Sejarah", new Penulis("Ahmad Sahidin"), "Filsafat", 2019, "Buku ini membahas tentang bagaimana filsafat dapat digunakan untuk memahami sejarah."));
        daftarBuku.add(new Buku("Sejarah Pemikiran Ekonomi", new Penulis("Sukarmi"), "Filsafat", 2022, "Buku ini membahas tentang sejarah pemikiran ekonomi dari masa ke masa."));
        daftarBuku.add(new Buku("Filosofi Teras", new Penulis("Henry Manampiring"), "Filsafat", 2018, "Buku ini membahas tentang filosofi teras dan bagaimana menerapkannya dalam kehidupan sehari-hari."));

        daftarBuku.add(new Buku("Berlin", new Penulis("Theodor Plievier"), "Sejarah", 2017, "Buku ini membahas tentang sejarah kota Berlin dari masa lalu hingga kini."));
        daftarBuku.add(new Buku("The History of The Ancient World", new Penulis("Susan Wise Bauer"), "Sejarah", 2007, "Buku ini membahas tentang sejarah dunia kuno dan peradaban-peradabannya."));
        daftarBuku.add(new Buku("The Second World War", new Penulis("Antony Beevor"), "Sejarah", 2012, "Buku ini membahas tentang Perang Dunia II dan dampaknya bagi dunia."));
        daftarBuku.add(new Buku("1776", new Penulis("David McCullough"), "Sejarah", 2005, "Buku ini membahas tentang tahun 1776 dalam sejarah Amerika Serikat."));
        daftarBuku.add(new Buku("The Diary of a Young Girl", new Penulis("Anne Frank"), "Sejarah", 1947, "Buku ini adalah diary seorang gadis muda bernama Anne Frank saat Perang Dunia II."));
        daftarBuku.add(new Buku("Gadis Kretek", new Penulis("Ratih Kumala"), "Sejarah", 2012, "Buku ini membahas tentang sejarah kretek di Indonesia melalui kisah seorang gadis."));

        daftarBuku.add(new Buku("Sejarah Islam", new Penulis("Karen Armstrong"), "Agama", 2000, "Buku ini membahas tentang sejarah Islam dari awal hingga perkembangannya."));
        daftarBuku.add(new Buku("Mere Christianity", new Penulis("C.S. Lewis"), "Agama", 1952, "Buku ini membahas tentang dasar-dasar agama Kristen dan keyakinannya."));
        daftarBuku.add(new Buku("Secrets of Divine Love", new Penulis("A. Helwa"), "Agama", 2022, "Buku ini membahas tentang rahasia cinta ilahi dalam Islam dan bagaimana merasakannya."));
        daftarBuku.add(new Buku("Tafsir Ibnu Kathir", new Penulis("Ibnu Kathir"), "Agama", 2018, "Buku ini adalah tafsir Al-Qur'an yang terkenal karya Ibnu Kathir."));
        daftarBuku.add(new Buku("Sejarah Nabi Muhammad", new Penulis("Ibnu Hiyam"), "Agama", 2020, "Buku ini membahas tentang sejarah Nabi Muhammad SAW dan perjuangannya."));

        daftarBuku.add(new Buku("Psikologi Positif", new Penulis("Husaini Usman"), "Psikologi", 2019, "Buku ini membahas tentang psikologi positif dan bagaimana meningkatkan kebahagiaan."));
        daftarBuku.add(new Buku("Psikologi Abnormal", new Penulis("Kartini Kartono"), "Psikologi", 2017, "Buku ini membahas tentang psikologi abnormal dan gangguan mental."));
        daftarBuku.add(new Buku("Teori Kepribadian", new Penulis("Alwisol"), "Psikologi", 2011, "Buku ini membahas tentang berbagai teori kepribadian dan tokoh-tokohnya."));
        daftarBuku.add(new Buku("Psikologi Pendidikan", new Penulis("Ahmadi Abu"), "Psikologi", 2018, "Buku ini membahas tentang psikologi pendidikan dan bagaimana menerapkannya dalam pembelajaran."));
        daftarBuku.add(new Buku("Psikologi Kognitif", new Penulis("Aaron Beck"), "Psikologi", 2019, "Buku ini membahas tentang psikologi kognitif dan proses berpikir manusia."));

        daftarBuku.add(new Buku("The Prince", new Penulis("Niccolo Machiavelli"), "Politik", 1532, "Buku ini membahas tentang politik kekuasaan dan strategi Machiavelli."));
        daftarBuku.add(new Buku("Democrazy", new Penulis("Robert Dahl"), "Politik", 2005, "Buku ini membahas tentang demokrasi dan tantangannya dalam dunia modern."));
        daftarBuku.add(new Buku("Negara Kita", new Penulis("Mohammad Hatta"), "Politik", 1977, "Buku ini membahas tentang negara Indonesia dan cita-citanya."));
        daftarBuku.add(new Buku("Dari Soekarno Sampai SBY", new Penulis("Yusa Lasa Tata"), "Politik", 2014, "Buku ini membahas tentang sejarah politik Indonesia dari era Soekarno hingga SBY."));
        daftarBuku.add(new Buku("Sistem Politik Indonesia", new Penulis("Miriam Budiardjo"), "Politik", 2008, "Buku ini membahas tentang sistem politik Indonesia dan perkembangannya."));

        daftarBuku.add(new Buku("Namaku Alam", new Penulis("Leila Chudori"), "Fiksi", 2023, "Buku ini adalah novel fiksi yang menceritakan tentang kehidupan seorang anak bernama Alam."));
        daftarBuku.add(new Buku("Bumi Manusia", new Penulis("Pramoedya Ananta Toer"), "Fiksi", 1980, "Buku ini adalah novel fiksi yang menceritakan tentang kehidupan di era kolonial."));
        daftarBuku.add(new Buku("Ronggeng Dukuh Paruk", new Penulis("Ahmad Tohari"), "Fiksi", 1982, "Buku ini adalah novel fiksi yang menceritakan tentang kehidupan seorang ronggeng."));
        daftarBuku.add(new Buku("Perahu Kertas", new Penulis("Dewi Lestari"), "Fiksi", 2009, "Buku ini adalah novel fiksi yang menceritakan tentang cinta dan persahabatan."));
        daftarBuku.add(new Buku("Ayah", new Penulis("Andrea Hirata"), "Fiksi", 2015, "Buku ini adalah novel fiksi yang menceritakan tentang perjuangan seorang ayah."));

        // Menampilkan daftar buku dengan nomor urut
        System.out.println("=======================================================================================================");
        System.out.printf("%-5s %-40s %-15s %-15s %-35s\n", "No", "Judul Buku", "Tahun Terbit", "Kategori", "Penulis");
        System.out.println("=======================================================================================================");
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku buku = daftarBuku.get(i);
            System.out.printf("%-5d %-40s %-15d %-15s %-35s\n", (i + 1), buku.getJudul(), buku.getTahunTerbit(), buku.getKategori(), buku.getPenulis().getNama());
        }
        System.out.println("=======================================================================================================");

        // Meminta input dari pengguna untuk memilih buku
        System.out.println("\nMasukkan nomor buku yang ingin diproses:");
        int nomorBuku = scanner.nextInt();

        // Validasi input
        if (nomorBuku < 1 || nomorBuku > daftarBuku.size()) {
            System.out.println("Nomor buku tidak valid. Pastikan nomor yang dimasukkan sesuai dengan daftar.");
        } else {
            Buku buku = daftarBuku.get(nomorBuku - 1);

            // Menampilkan menu pilihan
            System.out.println("\nPilih operasi yang ingin dilakukan:");
            System.out.println("1. Tampilkan informasi buku");
            System.out.println("2. Hitung jumlah kata sinopsis");
            System.out.println("3. Hitung royalti (10%)");
            System.out.println("4. Hitung royalti (persentase tertentu)");
            System.out.println("5. Buat salinan buku");
            System.out.println("6. Cek tingkat kesamaan dengan buku lain");
            System.out.println("7. Keluar");

            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    // Menampilkan informasi buku
                    System.out.println("\nInformasi Buku:");
                    buku.displayInfo();
                    break;
                case 2:
                    // Menghitung jumlah kata sinopsis
                    System.out.println("\nJumlah kata sinopsis: " + buku.hitungJumlahKataSinopsis());
                    break;
                case 3:
                    // Menghitung royalti (1 parameter)
                    System.out.println("\nMasukkan harga buku untuk menghitung royalti (10%):");
                    double hargaBuku = scanner.nextDouble();
                    System.out.println("Royalti (10%): Rp" + buku.hitungRoyalti(hargaBuku));
                    break;
                case 4:
                    // Menghitung royalti (2 parameter)
                    System.out.println("\nMasukkan harga buku:");
                    hargaBuku = scanner.nextDouble();
                    System.out.println("Masukkan persentase royalti (contoh: 15 untuk 15%):");
                    double persenRoyalti = scanner.nextDouble();
                    System.out.println("Royalti (" + persenRoyalti + "%): Rp" + buku.hitungRoyalti(hargaBuku, persenRoyalti));
                    break;
                case 5:
                    // Membuat salinan buku
                    Buku bukuSalinan = buku.copy();
                    System.out.println("\nInformasi Buku Salinan:");
                    bukuSalinan.displayInfo();
                    break;
                case 6:
                    // Cek plagiasi (tingkat kesamaan)
                    System.out.println("\nMasukkan nomor buku lain untuk memeriksa tingkat kesamaan:");
                    int nomorBukuLain = scanner.nextInt();
                    if (nomorBukuLain < 1 || nomorBukuLain > daftarBuku.size()) {
                        System.out.println("Nomor buku tidak valid.");
                    } else {
                        Buku bukuLain = daftarBuku.get(nomorBukuLain - 1);
                        double tingkatKesamaan = buku.cekTingkatKesamaan(bukuLain);
                        System.out.println("Tingkat kesamaan antara \"" + buku.getJudul() + "\" dan \"" + bukuLain.getJudul() + "\": " + tingkatKesamaan + "%");
                    }
                    break;
                case 7:
                    // Keluar dari program
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }
}
