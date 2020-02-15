export interface ApiResponse {
  id: number;
  name: string;
  address: {
    street: string,
    city: string,
    zipcode: string
  };
}
