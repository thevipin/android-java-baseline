package arch.line.base.baseline.utility.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    private static HeaderInterceptor headerInterceptor = null;
    private String authorization = "";

    private HeaderInterceptor() {
    }

    public static HeaderInterceptor createHeaderInterceptor() {
        if (headerInterceptor != null)
            return headerInterceptor;
        return headerInterceptor = new HeaderInterceptor();
    }

    public void setInterceptor(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        if (!authorization.isEmpty()) {
            Request.Builder builder = original.newBuilder();
            builder.addHeader("Accept", "application/json");
            builder.addHeader("Content-Type", "application/json");
            builder.addHeader("Authorization", authorization);
            original = builder.build();
        }
        return chain.proceed(original);
    }
}
