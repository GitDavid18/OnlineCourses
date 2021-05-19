#include <random>
#include <iostream>

int main()
{
  /* Initialise. Do this once (not for every
     random number). */
  std::random_device rd;
  std::mt19937_64 gen(rd());

  /* This is where you define the number generator for unsigned long long: */
  std::uniform_real_distribution<double> dis(1.0,10.0);
//   uniform_real_distribution<double> unif(MIN, MAX);

  /* A few random numbers: */    
  for (int n=0; n<10; ++n)
    std::cout << dis(gen) << '\n';
  std::cout << std::endl;
  return 0;
}