package com.vijaygenius123.service;

import com.vijaygenius123.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {
    Server createServer(Server server);
    Server ping(String ipAddress) throws IOException;
    Collection<Server> list(Integer limit);
    Server get(Long id);
    Boolean delete(Long id);
    Server update(Server server);
}
