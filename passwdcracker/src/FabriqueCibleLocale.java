public class FabriqueCibleLocale extends FabriqueCible {
    @Override
    public CibleAuthentification creerCible() {
        return new CibleLocale();
    }
} 