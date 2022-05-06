package functional.principles;

public class ImpureMethod {

    int m = 5;

    // Nakhalesh : chon be meghdari kharej az khodesh bastegi dare
    public int sum(int a, int b) {
        return a + b + m;
    }

    // Nakhales : chon yek meghdar kharej a khodesh ro taghir mide
    public int nakhales_2(int a, int b) {
        m++;
        return a + b;
    }

    // nakhales : Chon dar console/database/har chiz hareji taghir ijad mikone
    public void print(String s) {
        System.out.println(s);
        // db.save(s);
    }
}
