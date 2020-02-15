export interface User {
  firstname: string;
  lastname: string;
  age: number;
  address?: {
    city?: string,
    street?: string
  };
  showdetails?: boolean;
}

