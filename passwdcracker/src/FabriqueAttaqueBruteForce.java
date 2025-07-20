
public class FabriqueAttaqueBruteForce extends FabriqueAttaque {

    @Override
    public Attaque creerAttaque() {
        return new AttaqueBruteForce();
    }
}
