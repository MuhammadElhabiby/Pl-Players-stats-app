package com.elhabiby.PL.stats.app.Repo;

import com.elhabiby.PL.stats.app.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepo  extends JpaRepository<Player, String> {

    void deleteByName(String playerName);

    Optional<Player> findByName (String playerName);
}
