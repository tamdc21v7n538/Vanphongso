package com.vanphongso.tam.Controller;

import com.vanphongso.tam.entity.Room;
import com.vanphongso.tam.Sevice.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // ✅ Lấy tất cả
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // ✅ Lấy theo ID
    @GetMapping("/{id}")
    public Room getById(@PathVariable Long id) {
        return roomService.getById(id);
    }

    // ✅ Thêm phòng
    @PostMapping
    public Room create(@RequestBody Room room) {
        return roomService.create(room);
    }

    // ✅ Cập nhật
    @PutMapping("/{id}")
    public Room update(@PathVariable Long id, @RequestBody Room room) {
        return roomService.update(id, room);
    }

    // ✅ Xoá
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}