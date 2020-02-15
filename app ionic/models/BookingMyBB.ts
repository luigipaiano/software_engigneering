import {UserMyBB} from './UserMyBB';

export interface BookingMyBB {
  id: number;
  price: number;
  bookingDat: any;
  checkin: any;
  daynumber: number;
  user: UserMyBB;
}
