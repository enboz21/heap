public class heap {
    int[] dizimx;
    int[] dizimi;
    int boyut;
    int elemans;
    public heap(int boyut) {
        dizimx = new int[boyut];
        dizimi = new int[boyut];
        this.boyut = boyut;
        elemans = 0;
    }
    void yukarı(int no) {
        int noo=no;
        int root = (no - 1) / 2;
        while (root >= 0 && dizimx[root] < dizimx[no]) {
            int tmp = dizimx[root];
            dizimx[root] = dizimx[no];
            dizimx[no] = tmp;
            no = root;
            root = (no - 1) / 2;
        }
        no=noo;
        root = (no - 1) / 2;
        while (root >= 0 && dizimi[root] > dizimi[no]) {
            int tmp = dizimi[root];
            dizimi[root] = dizimi[no];
            dizimi[no] = tmp;
            no = root;
            root = (no - 1) / 2;
        }
    }
    boolean dolumu() {
        return elemans == boyut;
    }
    void ekle(int yeni) {
        if (!dolumu()) {
            dizimx[elemans] = yeni;
            dizimi[elemans] = yeni;
            elemans++;
            yukarı(elemans - 1);
        }
        else System.out.println("dolu");
    }
    void seemx() {
        for (int i = 0; i < elemans; i++) {
            System.out.print(dizimx[i] + "    ");
        }
        System.out.println("");
    }
    void seemi() {
        for (int i = 0; i < elemans; i++) {
            System.out.print(dizimi[i] + "    ");
        }
        System.out.println("");
    }
    void al(int dizi[]){
        this.dizimx=dizi;
        this.dizimi=dizi;
        //burda kaldın
    }
    
}
