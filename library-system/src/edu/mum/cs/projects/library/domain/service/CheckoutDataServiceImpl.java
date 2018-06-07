package edu.mum.cs.projects.library.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.mum.cs.projects.library.DataRecords;
import edu.mum.cs.projects.library.domain.entity.BookCopy;
import edu.mum.cs.projects.library.domain.entity.CheckoutEntry;
import edu.mum.cs.projects.library.domain.entity.CheckoutRecord;
import edu.mum.cs.projects.library.domain.entity.User;
import edu.mum.cs.projects.library.domain.entity.dto.CheckAvailabilityResult;

public class CheckoutDataServiceImpl implements CheckoutDataService {

	@Override
	public void checkoutBookCopy(User user, BookCopy bookCopy) {
		List<BookCopy> bookCopies = DataRecords.getAllBookCopies();
		BookCopy copy = bookCopies.stream().filter(c -> c.getBook().getIsbn().equals(bookCopy.getBook().getIsbn()))
				.collect(Collectors.toList()).get(0);

		CheckoutRecord checkoutRecord = new CheckoutRecord("1", LocalDate.now(), null, user, null);
		checkoutRecord.setCheckoutEntries(new ArrayList<CheckoutEntry>());
		checkoutRecord.getCheckoutEntries().add(new CheckoutEntry(LocalDate.now(),
				LocalDate.now().plusDays(copy.getBook().getAllowedBorrowedDays()), bookCopy, null));

	}

	@Override
	public CheckAvailabilityResult checkoutAvailability(String memberId, String isbn) {
		List<BookCopy> bookCopies = DataRecords.getAllBookCopies();
		CheckAvailabilityResult result = new CheckAvailabilityResult(false, false);
		result.setBookExists(bookCopies.stream().anyMatch(c -> c.getBook().getIsbn().equals(isbn)));
		result.setBookNotAvailable(
				bookCopies.stream().anyMatch(c -> c.getBook().getIsbn().equals(isbn) && c.getBook().getAvailability()));
		return result;
	}

	@Override
	public void markBookAsAnavailable(BookCopy bookCopy) {
		List<BookCopy> bookCopies = DataRecords.getAllBookCopies();
		BookCopy copy = bookCopies.stream().filter(c -> c.getBook().getIsbn().equals(bookCopy.getBook().getIsbn()))
				.collect(Collectors.toList()).get(0);
		copy.getBook().setAvailability(false);

		bookCopies.forEach(c -> {
			if (c.getBook().getIsbn().equals(bookCopy.getBook().getIsbn())) {
				c.getBook().setAvailability(false);
			}
		});
	}

}
