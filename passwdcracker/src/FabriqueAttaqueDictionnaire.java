
public class FabriqueAttaqueDictionnaire extends FabriqueAttaque {

    @Override
    public Attaque creerAttaque() {
        return new AttaqueDictionnaire();
    }
}
