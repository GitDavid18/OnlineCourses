#include <iostream>
#include <vector>

template <typename T>
class Matrix2D 
{
    std::vector<T> data;
    unsigned int sizeX, sizeY;

    public:
    Matrix2D (unsigned int x, unsigned int y) : sizeX (x), sizeY (y) {
        data.resize (sizeX*sizeY);
    }

    T& operator()(unsigned int x, unsigned int y) {
        if (x >= sizeX || y>= sizeY)
            throw std::logic_error("OOB access");
        return data[sizeX*y + x]; // Stride-aware access
    }
};


int main() {

  const int N = 10;
  const int M = 10;
  Matrix2D<int> matrix(N,M);
  matrix(0,0) = 42;
  
  std::cout << matrix(0,0) << std::endl;
    
  return 0;
}