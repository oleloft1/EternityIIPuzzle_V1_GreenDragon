package Types;

import mask.DirectionMask;

import java.util.ArrayList;
import java.util.List;

public class UnusedPieceLists {
    private List<Integer> cornersNE;
    private List<Integer> cornersNW;
    private List<Integer> cornersSE;
    private List<Integer> cornersSW;

    private List<Integer> borderNorth;
    private List<Integer> borderEast;
    private List<Integer> borderSouth;
    private List<Integer> borderWest;
    private List<Integer> normal;

    private int size;

    public UnusedPieceLists(List<Integer> cornersNE, List<Integer> cornersNW, List<Integer> cornersSE, List<Integer> cornersSW, List<Integer> borderNorth, List<Integer> borderEast, List<Integer> borderSouth, List<Integer> borderWest, List<Integer> normal) {
        this.cornersNE = cornersNE;
        this.cornersNW = cornersNW;
        this.cornersSE = cornersSE;
        this.cornersSW = cornersSW;
        this.borderNorth = borderNorth;
        this.borderEast = borderEast;
        this.borderSouth = borderSouth;
        this.borderWest = borderWest;
        this.normal = normal;

        size = this.cornersNE.size() +
                this.cornersNW.size() +
                this.cornersSE.size() +
                this.cornersSW.size() +
                this.borderNorth.size() +
                this.borderEast.size() +
                this.borderSouth.size() +
                this.borderEast.size() +
                this.normal.size();
    }

    public int getSize() {
        return size;
    }

    public void removePieceFromList(Integer piece, int fieldPosition) {
        int direction1 = (DirectionMask.getMaskNorth() & piece) >> DirectionMask.SHIFT_NORTH;
        int direction2 = (DirectionMask.getMaskEast() & piece) >> DirectionMask.SHIFT_EAST;
        int direction3 = (DirectionMask.getMaskSouth() & piece) >> DirectionMask.SHIFT_SOUTH;
        int direction4 = (DirectionMask.getMaskWest() & piece) >> DirectionMask.SHIFT_WEST;

        int mask1 = (direction1 << DirectionMask.SHIFT_NORTH) | (direction2 << DirectionMask.SHIFT_EAST) | (direction3 << DirectionMask.SHIFT_SOUTH) | (direction4 << DirectionMask.SHIFT_WEST);
        int mask2 = (direction4 << DirectionMask.SHIFT_NORTH) | (direction1 << DirectionMask.SHIFT_EAST) | (direction2 << DirectionMask.SHIFT_SOUTH) | (direction3 << DirectionMask.SHIFT_WEST);
        int mask3 = (direction3 << DirectionMask.SHIFT_NORTH) | (direction4 << DirectionMask.SHIFT_EAST) | (direction1 << DirectionMask.SHIFT_SOUTH) | (direction2 << DirectionMask.SHIFT_WEST);
        int mask4 = (direction2 << DirectionMask.SHIFT_NORTH) | (direction3 << DirectionMask.SHIFT_EAST) | (direction4 << DirectionMask.SHIFT_SOUTH) | (direction1 << DirectionMask.SHIFT_WEST);

        removePieceFromUnusedList(mask1, fieldPosition);
        removePieceFromUnusedList(mask2, fieldPosition);
        removePieceFromUnusedList(mask3, fieldPosition);
        removePieceFromUnusedList(mask4, fieldPosition);

        size = this.cornersNE.size() +
                this.cornersNW.size() +
                this.cornersSE.size() +
                this.cornersSW.size() +
                this.borderNorth.size() +
                this.borderEast.size() +
                this.borderSouth.size() +
                this.borderEast.size() +
                this.normal.size();
    }

    private void removePieceFromUnusedList(int piece, int fieldPosition) {
        if ((fieldPosition == 0) |
                (fieldPosition == 15) ||
                (fieldPosition == 240) ||
                (fieldPosition == 255)) {
            this.cornersNE = removePieceNoFromList(cornersNE, piece);
            this.cornersNW = removePieceNoFromList(cornersNW, piece);
            this.cornersSE = removePieceNoFromList(cornersSE, piece);
            this.cornersSW = removePieceNoFromList(cornersSW, piece);
        } else {
            if (((fieldPosition > 0) && (fieldPosition < 15)) ||
                    ((fieldPosition > 240) && (fieldPosition < 255))) {
                this.borderNorth = removePieceNoFromList(borderNorth, piece);
                this.borderEast = removePieceNoFromList(borderEast, piece);
                this.borderSouth = removePieceNoFromList(borderSouth, piece);
                this.borderWest = removePieceNoFromList(borderWest, piece);
            } else {
                if ((fieldPosition == 16) || (fieldPosition == 32) || (fieldPosition == 48) || (fieldPosition == 64) ||
                        (fieldPosition == 80) || (fieldPosition == 96) || (fieldPosition == 112) || (fieldPosition == 128) ||
                        (fieldPosition == 144) || (fieldPosition == 160) || (fieldPosition == 176) || (fieldPosition == 192) ||
                        (fieldPosition == 208) || (fieldPosition == 224)  || (fieldPosition == 31) ||
                        (fieldPosition == 47) || (fieldPosition == 63) || (fieldPosition == 79) || (fieldPosition == 95) ||
                        (fieldPosition == 111) || (fieldPosition == 127) || (fieldPosition == 143) || (fieldPosition == 159) ||
                        (fieldPosition == 179) || (fieldPosition == 191) || (fieldPosition == 207) || (fieldPosition == 223) ||
                        (fieldPosition == 239)) {
                    this.borderNorth = removePieceNoFromList(borderNorth, piece);
                    this.borderEast = removePieceNoFromList(borderEast, piece);
                    this.borderSouth = removePieceNoFromList(borderSouth, piece);
                    this.borderWest = removePieceNoFromList(borderWest, piece);
                } else {
                    this.normal = removePieceNoFromList(normal, piece);
                }
            }
        }
    }

    private List<Integer> removePieceNoFromList(List<Integer> list, int removePiece) {
        List<Integer> newList = new ArrayList<>(list);

        for (int i = 0; i < newList.size(); i++) {
            if (list.get(i) == removePiece) {
                newList.remove(i);
                return newList;
            }
        }

        return newList;
    }

    public List<Integer> getCornersNE() {
        return cornersNE;
    }

    public List<Integer> getCornersNW() {
        return cornersNW;
    }

    public List<Integer> getCornersSE() {
        return cornersSE;
    }

    public List<Integer> getCornersSW() {
        return cornersSW;
    }

    public List<Integer> getBorderNorth() {
        return borderNorth;
    }

    public List<Integer> getBorderEast() {
        return borderEast;
    }

    public List<Integer> getBorderSouth() {
        return borderSouth;
    }

    public List<Integer> getBorderWest() {
        return borderWest;
    }

    public List<Integer> getNormal() {
        return normal;
    }

    public UnusedPieceLists copy() {
        List<Integer> copyCornersNE = copyList(this.cornersNE);
        List<Integer> copyCornersNW = copyList(this.cornersNW);
        List<Integer> copyCornersSE = copyList(this.cornersSE);
        List<Integer> copyCornersSW = copyList(this.cornersSW);
        List<Integer> copyBorderNorth = copyList(this.borderNorth);
        List<Integer> copyBorderEast = copyList(this.borderEast);
        List<Integer> copyBorderSouth = copyList(this.borderSouth);
        List<Integer> copyBorderWest = copyList(this.borderWest);
        List<Integer> copyNormal = copyList(this.normal);

        return new UnusedPieceLists(copyCornersNE, copyCornersNW, copyCornersSE, copyCornersSW, copyBorderNorth, copyBorderEast, copyBorderSouth, copyBorderWest, copyNormal);
    }

    private List<Integer> copyList(List<Integer> listToCopy) {
        return new ArrayList<>(listToCopy);
    }
}
