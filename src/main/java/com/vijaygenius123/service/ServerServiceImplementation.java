package com.vijaygenius123.service;

import com.vijaygenius123.enumaration.Status;
import com.vijaygenius123.model.Server;
import com.vijaygenius123.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImplementation implements ServerService{

    private final ServerRepository serverRepository;

    @Override
    public Server createServer(Server server) {
        log.info("Saving New Server:  {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging Server With IP {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(Integer limit) {
        log.info("Fetching All Servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching Server With ID {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Server With ID {}", id);
        serverRepository.deleteById(id);
        return true;
    }

    @Override
    public Server update(Server server) {
        log.info("Updating Server With Name {}", server.getName());
        return serverRepository.save(server);
    }
}
