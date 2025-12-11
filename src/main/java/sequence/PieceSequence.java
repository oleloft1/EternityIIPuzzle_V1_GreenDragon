package sequence;

import java.util.List;

public class PieceSequence {

    private List<Integer> playSequence;

    public PieceSequence(List<Integer> playSequence) {
        this.playSequence = playSequence;
    }

    public int getSequenceToNo(int no) {
        return playSequence.get(no);
    }

    @Override
    public String toString() {
        return "PieceSequence{" +
                "playSequence=" + playSequence +
                '}';
    }
}
