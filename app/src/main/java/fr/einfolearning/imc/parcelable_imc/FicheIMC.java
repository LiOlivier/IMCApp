package fr.einfolearning.imc.parcelable_imc;

import android.os.Parcel;
import android.os.Parcelable;

public class FicheIMC implements Parcelable {
    private float valeurIMC;
    private String interpretation;

    public FicheIMC(float valeurIMC, String interpretation) {
        this.valeurIMC = valeurIMC;
        this.interpretation = interpretation;
    }

    protected FicheIMC(Parcel in) {
        valeurIMC = in.readFloat();
        interpretation = in.readString();
    }

    public static final Creator<FicheIMC> CREATOR = new Creator<FicheIMC>() {
        @Override
        public FicheIMC createFromParcel(Parcel in) {
            return new FicheIMC(in);
        }

        @Override
        public FicheIMC[] newArray(int size) {
            return new FicheIMC[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(valeurIMC);
        dest.writeString(interpretation);
    }
}
