package provider.client;

import provider.Provider;

public abstract class ProviderClientFactory {
    public abstract ProviderClient createClient(Provider provider);
}
