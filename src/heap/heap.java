package heap;

public class heap {

    /**
     * en büyük en üste olacak şekilde ayarlanıyor
     */
    private int[] dizimx;
    /**
     * en küçük en üste olacak şekilde ayarlanıyor
     */
    private int[] dizimi;
    private int boyut;
    private int elemans;

    /**
     * dizinin alabileceği max verimiktarı yazılır
     */
    public heap(int boyut) {
        dizimx = new int[boyut];
        dizimi = new int[boyut];
        this.boyut = boyut;
        elemans = 0;
    }

    /*burada ilk while de dağa büyük deyer bir üst köke(root)ile yer deyiştiri
        ikinci while de dağa küçük deyer bir üstdeyerle yer deyiştiri
     */
    void yukarı(int no) {
        int noo = no;
        int root = (no - 1) / 2;
        while (root >= 0 && dizimx[root] < dizimx[no]) {
            int tmp = dizimx[root];
            dizimx[root] = dizimx[no];
            dizimx[no] = tmp;
            no = root;
            root = (no - 1) / 2;
        }
        no = noo;
        root = (no - 1) / 2;
        while (root >= 0 && dizimi[root] > dizimi[no]) {
            int tmp = dizimi[root];
            dizimi[root] = dizimi[no];
            dizimi[no] = tmp;
            no = root;
            root = (no - 1) / 2;
        }
    }

    /**
     * dizinin max doluluna ulaşıldımı kontrol için
     */
    public boolean dolumu() {
        return elemans == boyut;
    }

    /**
     * ekleme işlemi yapra ardından yukarı metodunu çağırır
     */
    public void ekle(int yeni) {
        if (!dolumu()) {
            dizimx[elemans] = yeni;
            dizimi[elemans] = yeni;
            elemans++;
            yukarı(elemans - 1);
        } else {
            System.out.println("dolu");
        }
    }

    /**
     * en büyük deyere göre dizilenleri yazdırırı
     */
    public void seemx() {
        for (int i = 0; i < elemans; i++) {
            System.out.print(dizimx[i] + "    ");
        }
        System.out.println("");
    }

    /**
     * en küçük deyere göre dizilenleri yazdırırı
     */
    public void seemi() {
        for (int i = 0; i < elemans; i++) {
            System.out.print(dizimi[i] + "    ");
        }
        System.out.println("");
    }

}
