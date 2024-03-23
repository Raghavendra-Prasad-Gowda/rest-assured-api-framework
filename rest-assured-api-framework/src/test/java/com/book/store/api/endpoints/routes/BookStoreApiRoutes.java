package com.book.store.api.endpoints.routes;

public class BookStoreApiRoutes {
    private static final String BOOKSTORE = "/BookStore";
    private static final String ACCOUNT = "/Account";
    private static final String VERSION = "/v1";

    public static String getGenerateTokenRoute() {
        return ACCOUNT + VERSION + "/GenerateToken";
    }

    public static String getBooksListRoute() {
        return BOOKSTORE + VERSION + "/Books";
    }

    public static String getRemoveBookRoute() {
        return BOOKSTORE + VERSION + "/Book";
    }

    public static String getUserAccountRoute(String userId) {
        return ACCOUNT + VERSION + "/User" + "/" + userId;
    }
}
