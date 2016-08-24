/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 18, 2013

*/


import java.util.Scanner;


public class GuessingGame {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Guessing Game!");
		System.out.print("Enter a number to be guessed or -1 for a random number from the computer: ");
		double r = Math.random();
		int rnum = (int)(r*100)+1;
	
		int num = s.nextInt();
		
		
		
		if (num <= 100 && num >= 1){
			System.out.println("Number selected!");
			System.out.print("First Guess: ");
			int guess1 = s.nextInt();
			
			if (guess1 < num){
				System.out.println("Higher!");
				System.out.print("Second Guess: ");
				int guess2 = s.nextInt();
				
				if (guess2 < num){
				System.out.println("Higher!");
				System.out.print("Third Guess: ");
				int guess3 = s.nextInt();
				
					if (guess3 < num){
						System.out.println("Higher!");
						System.out.print("Fourth Guess: ");
						int guess4 = s.nextInt();
						
							if (guess4 < num){
								System.out.println("Higher!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != num){System.out.println("You lose!  The number was: " + num);}
									else if (guess5 == num){System.out.println("You win!");}
							}
							else if (guess4 > num){
								System.out.println("Lower!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != num){
										if(guess5 < num){System.out.println("Lower!");}
										else if(guess5 > num){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + num);}
									else if (guess5 == num){System.out.println("You win!");}
							}
							else if (guess4 == num){System.out.println("You win!");}
							else{System.out.println("That was not a valid entry");}
					}
					else if (guess3 > num){
						System.out.println("Lower!");
						System.out.print("Fourth Guess: ");
						int guess4 = s.nextInt();
						
							if (guess4 < num){
								System.out.println("Higher!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
													
									if (guess5 != num){
										if(guess5 > num){System.out.println("Lower!");}
										else if(guess5 < num){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + num);}
									else if (guess5 == num){System.out.println("You win!");}
							}
							else if (guess4 > num){
								System.out.println("Lower!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != num){
										if(guess5 > num){System.out.println("Lower!");}
										else if(guess5 < num){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + num);}
									else if (guess5 == num){System.out.println("You win!");}
							}
							else if (guess4 == num){System.out.println("You win!");}
							else{System.out.println("That was not a valid entry");}
					}
					else if (guess3 == num){System.out.println("You win!");}
					else{System.out.println("That was not a valid entry");}	
				}
				
				
				
				
				else if (guess2 > num){
					System.out.println("Lower!");
					System.out.print("Third Guess: ");
					int guess3 = s.nextInt();
					
						if (guess3 < num){
							System.out.println("Higher!");
							System.out.print("Fourth Guess: ");
							int guess4 = s.nextInt();
							
								if (guess4 < num){
									System.out.println("Higher!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != num){
											if(guess5 > num){System.out.println("Lower!");}
											else if(guess5 < num){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + num);}
										else if (guess5 == num){System.out.println("You win!");}
								}
								else if (guess4 > num){
									System.out.println("Lower!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != num){
											if(guess5 > num){System.out.println("Lower!");}
											else if(guess5 < num){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + num);}
										else if (guess5 == num){System.out.println("You win!");}
								}
								else if (guess4 == num){System.out.println("You win!");}
								else{System.out.println("That was not a valid entry");}
						}
						else if (guess3 > num){
							System.out.println("Lower!");
							System.out.print("Fourth Guess: ");
							int guess4 = s.nextInt();
							
								if (guess4 < num){
									System.out.println("Higher!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
														
										if (guess5 != num){
											if(guess5 > num){System.out.println("Lower!");}
											else if(guess5 < num){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + num);}
										else if (guess5 == num){System.out.println("You win!");}
								}
								else if (guess4 > num){
									System.out.println("Lower!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != num){
											if(guess5 > num){System.out.println("Lower!");}
											else if(guess5 < num){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + num);}
										else if (guess5 == num){System.out.println("You win!");}
								}
								else if (guess4 == num){System.out.println("You win!");}
								else{System.out.println("That was not a valid entry");}
						}
						else if (guess3 == num){System.out.println("You win!");}
						else{System.out.println("That was not a valid entry");}		
				}
				else if (guess2 == num){System.out.println("You win!");}
				else{System.out.println("That was not a valid entry");}	
			}
			
			
			
			
			
			
			else if (guess1 > num){
				System.out.println("Lower!");
				System.out.print("Second Guess: ");
				int guess2 = s.nextInt();
				
				if (guess2 < num){
				System.out.println("Higher!");
				System.out.print("Third Guess: ");
				int guess3 = s.nextInt();
				
					if (guess3 < num){
						System.out.println("Higher!");
						System.out.print("Fourth Guess: ");
						int guess4 = s.nextInt();
						
							if (guess4 < num){
								System.out.println("Higher!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != num){
										if(guess5 > num){System.out.println("Lower!");}
										else if(guess5 < num){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + num);}
									else if (guess5 == num){System.out.println("You win!");}
							}
							else if (guess4 > num){
								System.out.println("Lower!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != num){
										if(guess5 > num){System.out.println("Lower!");}
										else if(guess5 < num){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + num);}
									else if (guess5 == num){System.out.println("You win!");}
							}
							else if (guess4 == num){System.out.println("You win!");}
							else{System.out.println("That was not a valid entry");}
					}
					else if (guess3 > num){
						System.out.println("Lower!");
						System.out.print("Fourth Guess: ");
						int guess4 = s.nextInt();
						
							if (guess4 < num){
								System.out.println("Higher!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
													
									if (guess5 != num){
										if(guess5 > num){System.out.println("Lower!");}
										else if(guess5 < num){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + num);}
									else if (guess5 == num){System.out.println("You win!");}
							}
							else if (guess4 > num){
								System.out.println("Lower!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != num){
										if(guess5 > num){System.out.println("Lower!");}
										else if(guess5 < num){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + num);}
									else if (guess5 == num){System.out.println("You win!");}
							}
							else if (guess4 == num){System.out.println("You win!");}
							else{System.out.println("That was not a valid entry");}
					}
					else if (guess3 == num){System.out.println("You win!");}
					else{System.out.println("That was not a valid entry");}	
				}
				
				
				
				
				else if (guess2 > num){
					System.out.println("Lower!");
					System.out.print("Third Guess: ");
					int guess3 = s.nextInt();
					
						if (guess3 < num){
							System.out.println("Higher!");
							System.out.print("Fourth Guess: ");
							int guess4 = s.nextInt();
							
								if (guess4 < num){
									System.out.println("Higher!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != num){
											if(guess5 > num){System.out.println("Lower!");}
											else if(guess5 < num){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + num);}
										else if (guess5 == num){System.out.println("You win!");}
								}
								else if (guess4 > num){
									System.out.println("Lower!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != num){
											if(guess5 > num){System.out.println("Lower!");}
											else if(guess5 < num){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + num);}
										else if (guess5 == num){System.out.println("You win!");}
								}
								else if (guess4 == num){System.out.println("You win!");}
								else{System.out.println("That was not a valid entry");}
						}
						else if (guess3 > num){
							System.out.println("Lower!");
							System.out.print("Final Guess: ");
							int guess4 = s.nextInt();
							
								if (guess4 < num){
									System.out.println("Higher!");
									System.out.print("Fifth Guess: ");
									int guess5 = s.nextInt();
														
										if (guess5 != num){
											if(guess5 > num){System.out.println("Lower!");}
											else if(guess5 < num){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + num);}
										else if (guess5 == num){System.out.println("You win!");}
								}
								else if (guess4 > num){
									System.out.println("Lower!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != num){
											if(guess5 > num){System.out.println("Lower!");}
											else if(guess5 < num){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + num);}
										else if (guess5 == num){System.out.println("You win!");}
								}
								else if (guess4 == num){System.out.println("You win!");}
								else{System.out.println("That was not a valid entry");}
						}
						else if (guess3 == num){System.out.println("You win!");}
						else{System.out.println("That was not a valid entry");}		
				}
				else if (guess2 == num){System.out.println("You win!");}
				else{System.out.println("That was not a valid entry");}
			}
			else if (guess1 == num){System.out.println("You win!");}
			else{System.out.println("That was not a valid entry");}
		}
		else if (num > 100 || num < 1){
			if (num == -1){
			System.out.println("Number selected!");
			System.out.print("First Guess: ");
		

			int guess1 = s.nextInt();
			
			
			if (guess1 < rnum){
				System.out.println("Higher!");
				System.out.print("Second Guess: ");
				int guess2 = s.nextInt();
				
				if (guess2 < rnum){
				System.out.println("Higher!");
				System.out.print("Third Guess: ");
				int guess3 = s.nextInt();
				
					if (guess3 < rnum){
						System.out.println("Higher!");
						System.out.print("Fourth Guess: ");
						int guess4 = s.nextInt();
						
							if (guess4 < rnum){
								System.out.println("Higher!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != rnum){
										if(guess5 > rnum){System.out.println("Lower!");}
										else if(guess5 < rnum){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + rnum);}
									else if (guess5 == rnum){System.out.println("You win!");}
							}
							else if (guess4 > rnum){
								System.out.println("Lower!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != rnum){
										if(guess5 > rnum){System.out.println("Lower!");}
										else if(guess5 < rnum){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + rnum);}
									else if (guess5 == rnum){System.out.println("You win!");}
							}
							else if (guess4 == rnum){System.out.println("You win!");}
							else{System.out.println("That was not a valid entry");}
					}
					else if (guess3 > rnum){
						System.out.println("Lower!");
						System.out.print("Fourth Guess: ");
						int guess4 = s.nextInt();
						
							if (guess4 < rnum){
								System.out.println("Higher!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
													
									if (guess5 != rnum){
										if(guess5 > rnum){System.out.println("Lower!");}
										else if(guess5 < rnum){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + rnum);}
									else if (guess5 == rnum){System.out.println("You win!");}
							}
							else if (guess4 > rnum){
								System.out.println("Lower!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != rnum){
										if(guess5 > rnum){System.out.println("Lower!");}
										else if(guess5 < rnum){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + rnum);}
									else if (guess5 == rnum){System.out.println("You win!");}
							}
							else if (guess4 == rnum){System.out.println("You win!");}
							else{System.out.println("That was not a valid entry");}
					}
					else if (guess3 == rnum){System.out.println("You win!");}
					else{System.out.println("That was not a valid entry");}	
				}
				
				
				
				
				else if (guess2 > rnum){
					System.out.println("Lower!");
					System.out.print("Third Guess: ");
					int guess3 = s.nextInt();
					
						if (guess3 < rnum){
							System.out.println("Higher!");
							System.out.print("Fourth Guess: ");
							int guess4 = s.nextInt();
							
								if (guess4 < rnum){
									System.out.println("Higher!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != rnum){
											if(guess5 > rnum){System.out.println("Lower!");}
											else if(guess5 < rnum){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + rnum);}
										else if (guess5 == rnum){System.out.println("You win!");}
								}
								else if (guess4 > rnum){
									System.out.println("Lower!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != rnum){
											if(guess5 > rnum){System.out.println("Lower!");}
											else if(guess5 < rnum){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + rnum);}
										else if (guess5 == rnum){System.out.println("You win!");}
								}
								else if (guess4 == rnum){System.out.println("You win!");}
								else{System.out.println("That was not a valid entry");}
						}
						else if (guess3 > rnum){
							System.out.println("Lower!");
							System.out.print("Fourth Guess: ");
							int guess4 = s.nextInt();
							
								if (guess4 < rnum){
									System.out.println("Higher!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
														
										if (guess5 != rnum){
											if(guess5 > rnum){System.out.println("Lower!");}
											else if(guess5 < rnum){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + rnum);}
										else if (guess5 == rnum){System.out.println("You win!");}
								}
								else if (guess4 > rnum){
									System.out.println("Lower!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != rnum){
											if(guess5 > rnum){System.out.println("Lower!");}
											else if(guess5 < rnum){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + rnum);}
										else if (guess5 == rnum){System.out.println("You win!");}
								}
								else if (guess4 == rnum){System.out.println("You win!");}
								else{System.out.println("That was not a valid entry");}
						}
						else if (guess3 == rnum){System.out.println("You win!");}
						else{System.out.println("That was not a valid entry");}		
				}
				else if (guess2 == rnum){System.out.println("You win!");}
				else{System.out.println("That was not a valid entry");}	
			}
			
			
			
			
			
			
			else if (guess1 > rnum){
				System.out.println("Lower!");
				System.out.print("Second Guess: ");
				int guess2 = s.nextInt();
				
				if (guess2 < rnum){
				System.out.println("Higher!");
				System.out.print("Third Guess: ");
				int guess3 = s.nextInt();
				
					if (guess3 < rnum){
						System.out.println("Higher!");
						System.out.print("Fourth Guess: ");
						int guess4 = s.nextInt();
						
							if (guess4 < rnum){
								System.out.println("Higher!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != rnum){
										if(guess5 > rnum){System.out.println("Lower!");}
										else if(guess5 < rnum){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + rnum);}
									else if (guess5 == rnum){System.out.println("You win!");}
							}
							else if (guess4 > rnum){
								System.out.println("Lower!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != rnum){
										if(guess5 > rnum){System.out.println("Lower!");}
										else if(guess5 < rnum){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + rnum);}
									else if (guess5 == rnum){System.out.println("You win!");}
							}
							else if (guess4 == rnum){System.out.println("You win!");}
							else{System.out.println("That was not a valid entry");}
					}
					else if (guess3 > rnum){
						System.out.println("Lower!");
						System.out.print("Fourth Guess: ");
						int guess4 = s.nextInt();
						
							if (guess4 < rnum){
								System.out.println("Higher!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
													
									if (guess5 != rnum){
										if(guess5 > rnum){System.out.println("Lower!");}
										else if(guess5 < rnum){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + rnum);}
									else if (guess5 == rnum){System.out.println("You win!");}
							}
							else if (guess4 > rnum){
								System.out.println("Lower!");
								System.out.print("Final Guess: ");
								int guess5 = s.nextInt();
								
									if (guess5 != rnum){
										if(guess5 > rnum){System.out.println("Lower!");}
										else if(guess5 < rnum){System.out.println("Higher!");}
										System.out.println("You lose!  The number was: " + rnum);}
									else if (guess5 == rnum){System.out.println("You win!");}
							}
							else if (guess4 == rnum){System.out.println("You win!");}
							else{System.out.println("That was not a valid entry");}
					}
					else if (guess3 == rnum){System.out.println("You win!");}
					else{System.out.println("That was not a valid entry");}	
				}
				
				
				
				
				else if (guess2 > rnum){
					System.out.println("Lower!");
					System.out.print("Third Guess: ");
					int guess3 = s.nextInt();
					
						if (guess3 < rnum){
							System.out.println("Higher!");
							System.out.print("Fourth Guess: ");
							int guess4 = s.nextInt();
							
								if (guess4 < rnum){
									System.out.println("Higher!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != rnum){
											if(guess5 > rnum){System.out.println("Lower!");}
											else if(guess5 < rnum){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + rnum);}
										else if (guess5 == rnum){System.out.println("You win!");}
								}
								else if (guess4 > rnum){
									System.out.println("Lower!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != rnum){
											if(guess5 > rnum){System.out.println("Lower!");}
											else if(guess5 < rnum){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + rnum);}
										else if (guess5 == rnum){System.out.println("You win!");}
								}
								else if (guess4 == rnum){System.out.println("You win!");}
								else{System.out.println("That was not a valid entry");}
						}
						else if (guess3 > rnum){
							System.out.println("Lower!");
							System.out.print("Fourth Guess: ");
							int guess4 = s.nextInt();
							
								if (guess4 < rnum){
									System.out.println("Higher!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
														
										if (guess5 != rnum){
											if(guess5 > rnum){System.out.println("Lower!");}
											else if(guess5 < rnum){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + rnum);}
										else if (guess5 == rnum){System.out.println("You win!");}
								}
								else if (guess4 > rnum){
									System.out.println("Lower!");
									System.out.print("Final Guess: ");
									int guess5 = s.nextInt();
									
										if (guess5 != rnum){
											if(guess5 > rnum){System.out.println("Lower!");}
											else if(guess5 < rnum){System.out.println("Higher!");}
											System.out.println("You lose!  The number was: " + rnum);}
										else if (guess5 == rnum){System.out.println("You win!");}
								}
								else if (guess4 == rnum){System.out.println("You win!");}
								else{System.out.println("That was not a valid entry");}
						}
						else if (guess3 == rnum){System.out.println("You win!");}
						else{System.out.println("That was not a valid entry");}		
				}
				else if (guess2 == rnum){System.out.println("You win!");}
				else{System.out.println("That was not a valid entry");}
			}
			else if (guess1 == rnum){System.out.println("You win!");}
			else{System.out.println("That was not a valid entry");}
		}
			else{
				System.out.println("That was not a valid entry");
			}
		}
		else if (num!=-1){
			System.out.println("That was not a valid entry");
		}	
		
		s.close();
	
	}
}
