package user;

import user.Provider;

public enum WalletProvider implements Provider {
    VodafoneCash("Vodafone Cash"),
    CIB("CIB"),
    Fawry("Fawry");

    private final String label;

    private WalletProvider(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
