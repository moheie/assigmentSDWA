package provider.client.bank;

import provider.BankProvider;
import provider.Provider;
import provider.client.ProviderClient;
import provider.client.ProviderClientFactory;

public class BankClientFactory extends ProviderClientFactory {
    @Override
    public ProviderClient createClient(Provider provider) {
        return switch ((BankProvider) provider) {
            case HSBC -> new HSBCBankClient();
            case NBE -> new NBEBankClient();
            case MISR -> new MISRBankClient();
        };
    }
}
