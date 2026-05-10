#ifndef RANDGEN_H
#define RANDGEN_H

void randgen_init(unsigned int seed);
int  randgen_next(int min, int max);
void randgen_run_from_input(void);

#endif
