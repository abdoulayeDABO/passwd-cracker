public class FabriqueCibleEnLigne extends FabriqueCible {
    @Override
    public CibleAuthentification creerCible() {
        return new CibleEnLigne();
    }
} 