package com.mycorp.helloworld.templates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.appian.connectedsystems.simplified.sdk.SimpleClientApi;
import com.appian.connectedsystems.simplified.sdk.SimpleClientApiRequest;
import com.appian.connectedsystems.templateframework.sdk.ClientApiResponse;
import com.appian.connectedsystems.templateframework.sdk.ExecutionContext;
import com.appian.connectedsystems.templateframework.sdk.TemplateId;

import com.appiancorp.services.ServiceContext;
import com.appiancorp.services.ServiceContextFactory;
import com.appiancorp.suiteapi.applications.ApplicationNavigationItem;
import com.appiancorp.suiteapi.applications.ApplicationNotFoundException;
import com.appiancorp.suiteapi.applications.ApplicationService;
import com.appiancorp.suiteapi.common.ServiceLocator;
import com.appiancorp.suiteapi.common.exceptions.PrivilegeException;
import com.appiancorp.suiteapi.type.TypedValue;

@TemplateId(name = "BackgroundColorClientAPI")
public class BackgroundColorClientAPI extends SimpleClientApi {
  @Override
  protected ClientApiResponse execute(
      SimpleClientApiRequest simpleClientApiRequest,
      ExecutionContext executionContext) {


      // Application Context testing
//     ServiceContext ctx = ServiceContextFactory.getServiceContext("admin.user");
//    ApplicationService aps = ServiceLocator.getApplicationService(ctx);
//    try {
//      ApplicationNavigationItem[] navigationItems = aps.getApplicationByUuid(
//          "_a-0000e657-5c05-8000-7992-3cef903cef90_9971").getNavigationItems();
//      System.out.println("length: " + navigationItems.length);
//      System.out.println("first: " + navigationItems[0].getDisplayName());
//
//      for (ApplicationNavigationItem item : navigationItems) {
//
//        String name = item.getDisplayName();
//        String pageUuid = item.getPageUuid();
//        String urlId = item.getUrlIdentifier();
//
//        System.out.printf("Name: %s | Page UUID: %s | URL ID: %s%n",
//            name, pageUuid, urlId);
//      }
//
//    } catch (ApplicationNotFoundException e) {
//      throw new RuntimeException(e);
//    } catch (PrivilegeException e) {
//      throw new RuntimeException(e);
//    }

    simpleClientApiRequest.getPayload();
      Map<String, Object> responseMap = new HashMap<>();
    System.out.println("Background Color Client API hit");

    System.out.println("Payload:");
    for (Map.Entry<String, Object> entry : simpleClientApiRequest.getPayload().entrySet()) {
      System.out.println("  " + entry.getKey() + " = " + entry.getValue());
      responseMap.put("payload." + entry.getKey(), entry.getValue());
    }

    System.out.println("Encrypted Payload:");
    for (Map.Entry<String, Object> entry : simpleClientApiRequest.getSecuredPayload().entrySet()) {
      System.out.println("  " + entry.getKey() + " = " + entry.getValue());
      responseMap.put(
          "securedPayload." + entry.getKey(),
          entry.getValue() instanceof TypedValue ?
              entry.getValue().toString() :
              entry.getValue()
      );
    }

      return new ClientApiResponse(responseMap);

  }

}
