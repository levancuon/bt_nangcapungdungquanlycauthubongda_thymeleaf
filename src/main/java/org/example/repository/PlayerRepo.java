package org.example.repository;

import org.example.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PlayerRepo implements IPlayerRepo {
    private static final List<Player> list;

    static {
        list = new ArrayList<>();
        list.add(new Player("Messi", "2000/10/10", "10 năm", " Tiền đạo"));
        list.add(new Player("Ronaldo", "2000/10/10", "10 năm", " Tiền đạo"));
        list.add(new Player("Neymar", "2000/10/10", "10 năm", " Tiền đạo"));
        list.add(new Player("Beckam", "2000/10/10", "10 năm", " Tiền đạo"));
    }

    @Override
    public List<Player> findAll() {
        return list;
    }

    @Override
    public Player findById(int id) {
        for (Player item : list) {
            if (Objects.equals(item.getId(), id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void save(Player player) {
        Player player1 = new Player(player.getName(), player.getDob(), player.getExperience(), player.getPosition());
        list.add(player1);
    }

    @Override
    public void edit(Player player) {
        for (Player items : list) {
            if (items.getId() == player.getId()) {
                items.setName(player.getName());
                System.out.println(items.getName());
                System.out.println(player.getName());
                items.setDob(player.getDob());
                items.setExperience(player.getExperience());
                items.setPosition(player.getPosition());
            }
        }
        System.out.println("that bai");

    }

}
//Player player1 = findById(player.getId());
//        player1.setName(player.getName());
//        player1.setPosition(player.getPosition());
//        player1.setDob(player.getDob());
//        player1.setExperience(player.getExperience());
//        player1.setId(player.getId());