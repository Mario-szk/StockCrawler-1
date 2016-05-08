package info.xuding.stock.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class SimpleHttpLoader {

	public static String get(String url) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet httpGet = new HttpGet(url);
		System.out.println(httpGet.getRequestLine());
		try {
			// ִ��get����
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			// ��ȡ��Ӧ��Ϣʵ��
			HttpEntity entity = httpResponse.getEntity();
			// ��Ӧ״̬
			System.out.println("status:" + httpResponse.getStatusLine());
			// �ж���Ӧʵ���Ƿ�Ϊ��
			if (entity != null) {
				return EntityUtils.toString(entity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر������ͷ���Դ
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
