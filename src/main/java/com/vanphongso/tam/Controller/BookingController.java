package com.vanphongso.tam.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.vanphongso.tam.entity.RoomBooking;
import com.vanphongso.tam.repository.BookingRepository;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public List<RoomBooking> getAll() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public RoomBooking create(@RequestBody RoomBooking booking) {
        return bookingRepository.save(booking);
    }

    @PutMapping("/{id}/approve")
    public RoomBooking approve(@PathVariable Long id) {
        RoomBooking booking = bookingRepository.findById(id).orElseThrow();
        booking.setApproved(true);
        return bookingRepository.save(booking);
    }

    // ✅ DELETE booking
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }
}