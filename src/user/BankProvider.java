package user;

import user.Provider;

public enum BankProvider implements Provider {
    HSBC("HSBC"),
    NBE("National Bank of Egypt"),
    MISR("Banque Misr");

    private final String label;

    private BankProvider(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
