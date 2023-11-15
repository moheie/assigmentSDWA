package provider.client.wallet;

import provider.Provider;
import provider.WalletProvider;
import provider.client.ProviderClient;
import provider.client.ProviderClientFactory;

public class WalletClientFactory extends ProviderClientFactory {
    @Override
    public ProviderClient createClient(Provider provider) {
        return switch ((WalletProvider) provider) {
            case CIB -> new CIBWalletClient();
            case VodafoneCash -> new VodafoneCashWalletClient();
            case Fawry -> new FawryWalletClient();
        };
    }
}
