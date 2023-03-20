package Oblig1.Klient;

import Oblig1.Enum.Sjanger;
import Oblig1.Film;
import Oblig1.Tabell.Filmarkiv;
import Oblig1.adt.FilmarkivADT;
import Oblig1.kjedet.FIlmarkiv2;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start(){
        Film film1 = new Film(1, "Leo Gilje", "Balletaskern", 2021, Sjanger.KRIM, "Disney");
        Film film2 = new Film(2, "Oliver Kvebek", "Kreftpasienten", 2023, Sjanger.KOMEDIE, "Netflix");
        Film film3 = new Film(3, "John Ferarri", "Den lille gutten", 2023, Sjanger.PORNO, "Hong Kong studios");
        Film film4 = new Film(4, "Ole Johannes", "Den onde lærern", 2023, Sjanger.KOMEDIE, "HVL filmstudio");
        Film film5 = new Film(5, "Ole Johannes", "Den onde lærern", 2023, Sjanger.KOMEDIE, "HVL filmstudio");
        Film film6 = new Film(6, "Ole Johannes", "Den onde lærern", 2023, Sjanger.KOMEDIE, "HVL filmstudio");
        Film film7 = new Film(7, "Ole Johannes", "Den onde lærern", 2023, Sjanger.KOMEDIE, "HVL filmstudio");
        FIlmarkiv2 filmarkiv = new FIlmarkiv2();
        Filmarkiv filmarkivTabell = new Filmarkiv(3);
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);

        filmarkivTabell.leggTilFilm(film1);
        filmarkivTabell.leggTilFilm(film2);
        filmarkivTabell.leggTilFilm(film3);
        filmarkivTabell.leggTilFilm(film4);
        filmarkivTabell.leggTilFilm(film5);
        filmarkivTabell.leggTilFilm(film6);
        filmarkivTabell.leggTilFilm(film7);



        Film[] tittelsoek = filmarkivTabell.soekTittel("Balle");
        filmarkivTabell.skrivUt(tittelsoek);

        Film[] produsentsoek = filmarkivTabell.soekProdusent("Ole");
        filmarkivTabell.skrivUt(produsentsoek);



        Film[] tittelsoekKjedet = filmarkiv.soekProdusent("Oledasd");
        filmarkivTabell.skrivUt(tittelsoekKjedet);







    }

}
