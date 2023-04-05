package pl.retsuz.dataproviders;

import java.io.IOException;

public interface IRemoteDataProvider {
    public String acquireRemoteData(String address) throws IOException;
}