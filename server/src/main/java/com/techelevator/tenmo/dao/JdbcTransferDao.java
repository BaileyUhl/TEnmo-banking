package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcTransferDao implements TransferDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Transfer addNewTransfer(Transfer transfer) {
        String sql = "INSERT INTO transfer (transfer_amount, sender_name, receiver_name) " +
                "VALUES (?, ?, ?, ?) RETURNING transfer_id;";
        Integer newTransferId = jdbcTemplate.queryForObject(sql, Integer.class, transfer.getTransferAmount(),
                                        transfer.getSenderName(), transfer.getReceiverName());
        transfer.setTransferId(newTransferId);
        return transfer;
    }

    @Override
    public List<Transfer> getAllTransfersSentFromUser(String username) {
        String sql = "SELECT transfer_id, transfer_amount, sender_name, receiver_name " +
                "FROM transfer WHERE sender_name = ?;";
        List<Transfer> transfers = new ArrayList<>();
        SqlRowSet resultList = jdbcTemplate.queryForRowSet(sql, username);
        while (resultList.next()){
            transfers.add(mapRowToTransfer(resultList));
        }
        return transfers;
    }

    @Override
    public List<Transfer> getAllTransfersReceivedByUser(String username) {
        String sql = "SELECT transfer_id, transfer_amount, sender_name, receiver_name " +
                "FROM transfer WHERE receiver_name = ?;";
        List<Transfer> transfers = new ArrayList<>();
        SqlRowSet resultList = jdbcTemplate.queryForRowSet(sql, username);
        while (resultList.next()){
            transfers.add(mapRowToTransfer(resultList));
        }
        return transfers;
    }

    @Override
    public Transfer getTransferById(int id) {
        Transfer transfer = null;
       String sql ="SELECT transfer_id, transfer_amount, sender_name, receiver_name " +
                    "FROM transfer " +
                    "WHERE transfer_id = ?;";

       SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

       if (result.next())
       {
           transfer = mapRowToTransfer(result);
       }
       return transfer;
    }

    private Transfer mapRowToTransfer(SqlRowSet rowSet)
    {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rowSet.getInt("transfer_id"));
        transfer.setTransferAmount(rowSet.getDouble("transfer_amount"));
        transfer.setSenderName(rowSet.getString("sender_name"));
        transfer.setReceiverName(rowSet.getString("receiver_name"));
        return transfer;
    }

}
